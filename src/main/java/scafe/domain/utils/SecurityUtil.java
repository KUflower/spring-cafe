/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package scafe.domain.utils;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtil {
	
	
	public static UserDetails getCurrentUserDetails(){
		if(SecurityContextHolder.getContext() == null){
			return null;
		}
		if(SecurityContextHolder.getContext().getAuthentication() == null){
			return null;
		}
 	    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return (UserDetails)principal;
        }
        return null;
	}
	
	public static void signin(String userId) {
		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userId, null, null));	
	}
	public static String getId(StandardPBEStringEncryptor encryptor, String encryptId){
		return encrypt(encryptor, encryptId);
	}
	
	public static String encrypt(StandardPBEStringEncryptor encryptor, String message){
		return encryptor.encrypt(message);
	}
	
	public static String decrypt(StandardPBEStringEncryptor encryptor, String message){
		return encryptor.decrypt(message);
	}
	
}
