package woorifisa.goodfriends.backend.auth.dto.response;

// OAuth 인증 URI(소셜 로그인 링크)를 전달하는 DTO
public class OAuthUriResponse {

    private String oAuthUri;

    public OAuthUriResponse() {
    }

    public OAuthUriResponse(String oAuthUri) {
        this.oAuthUri = oAuthUri;
    }

    public String getoAuthUri() {
        return oAuthUri;
    }
}
