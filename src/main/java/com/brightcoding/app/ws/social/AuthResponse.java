package com.brightcoding.app.ws.social;

public class AuthResponse {
	 private String accessToken;
	  
	    private String id ;
	    

	    public AuthResponse(String accessToken) {
	        this.setAccessToken(accessToken);
	    }

		public String getAccessToken() {
			return accessToken;
		}

		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}

		public AuthResponse(String accessToken, String id) {
			super();
			this.accessToken = accessToken;
			this.id = id;
		}

	
		

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}


    // Getters and Setters (Omitted for brevity)
}