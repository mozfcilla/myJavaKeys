package myJavaKeys;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.spec.RSAPublicKeySpec;

public class myKeyGenerator {
	
	public static void main(String[] args) throws Exception{
		int eValue = 79;
		int bitLength = 1024;
		
		BigInteger e = e = new BigInteger(Integer.toString(eValue));
		
		KeyPairGenerator myKeyGen = KeyPairGenerator.getInstance("RSA");
		myKeyGen.initialize(bitLength);
		KeyPair kp = myKeyGen.generateKeyPair();
		
		KeyFactory kf = KeyFactory.getInstance("RSA");
		RSAPublicKeySpec kSpec = (RSAPublicKeySpec) kf.getKeySpec(kp.getPublic(),RSAPublicKeySpec.class);
		
		myKeyGen = KeyPairGenerator.getInstance("RSA", "SunRsaSign");
		
		e = new BigInteger(Integer.toString(eValue));
		System.out.println("e=" + e);
		RSAKeyGenParameterSpec param = new RSAKeyGenParameterSpec(bitLength, e);
		myKeyGen.initialize(param);
		kp = myKeyGen.generateKeyPair();
		
		kf = KeyFactory.getInstance("RSA","SunRsaSign");
		
		kSpec = (RSAPublicKeySpec) kf.getKeySpec(kp.getPublic(), RSAPublicKeySpec.class);
		
		System.out.println("Done with key Generation");
		
		
	}

}
