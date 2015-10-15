package com.securedsigning.rest.client;

import net.servicestack.client.ConnectionFilter;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

class ServiceClientRequestFilter implements ConnectionFilter {

    /**
     * Constants
     */
    public static final String HASH_ALGORITHM = "HmacSHA256";

    private Mac mac;
    private String apiKey;
    private String accessUrl;

    public ServiceClientRequestFilter(String key,String secret,String accessUrl) {
        this.apiKey=key;
        this.accessUrl=accessUrl;
        try {
            mac = Mac.getInstance(HASH_ALGORITHM);
            mac.init(new SecretKeySpec(secret.getBytes(), mac.getAlgorithm()));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method generates random string
     *
     * @return the random string
     */
    private String GeneratedRandomString() {
        String generatedString = RandomStringUtils.randomAlphabetic(32);

        return generatedString;
    }

    /**
     * Method concatenate the string in the required format.
     *
     * @param timestamp the timestamp
     * @param nonce     the nonce
     * @return the data
     */
    private String getSignature(long timestamp, String nonce, String apiKey)
            throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException
    {
        return getHash(apiKey + "\n" + String.valueOf(timestamp) + "\n" + nonce);
    }

    /**
     * returns Base64 encoded value of computed HMAC of data.
     *
     * @param data the data
     * @return the hash
     * @throws NoSuchAlgorithmException     the no such algorithm exception
     * @throws InvalidKeyException          the invalid key exception
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    private String getHash(String data)
            throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException
    {
        return Base64.encodeBase64String(mac.doFinal(data.getBytes()));
    }

    public void exec(java.net.HttpURLConnection httpURLConnection){

        httpURLConnection.setRequestProperty("Referer", accessUrl);

        //create a random string to be part of the signature
        String nonce = GeneratedRandomString();

        //get timestamp in seconds
        long timestamp = System.currentTimeMillis() / 1000;


        try {

            String signature = getSignature(timestamp, nonce, apiKey);

            httpURLConnection.setRequestProperty("X-CUSTOM-API-KEY", apiKey);
            httpURLConnection.setRequestProperty("X-CUSTOM-SIGNATURE",signature );
            httpURLConnection.setRequestProperty("X-CUSTOM-DATE",String.valueOf(timestamp));
            httpURLConnection.setRequestProperty("X-CUSTOM-NONCE", nonce);

            if(httpURLConnection.getRequestMethod()=="POST")
            {
                httpURLConnection.setDoOutput(true);
            }

        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
