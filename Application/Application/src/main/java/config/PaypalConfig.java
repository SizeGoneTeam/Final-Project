package config;
import java.util.HashMap;
import java.util.Map;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

public class PaypalConfig {
    
    private String clientId = "AacQ0Q5c7wRMX2tCwE8AVLPaOQ0rwaQRZhDoXtb78HD17Jba9BoDUNGgKWoFgmgvoTQ6ERQMhdYtwWuh";
    private String clientSecret = "EOEgqN1jb4xHBJsVzL6fjYSaeMPsT_uKeRb61LibzsWfQIRN4Km_aMDZrfRw8NGgr6V7Y3jU0VNa0lbO";
    private String mode = "sandbox";
    
    public Map paypalSdkConfig(){
        Map sdkConfig = new HashMap<>();
        sdkConfig.put("mode", mode);
        return sdkConfig;
    }
    
    public OAuthTokenCredential authTokenCredential(){
        return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
    }
    
    public APIContext apiContext() throws PayPalRESTException{
        APIContext apiContext = new APIContext(authTokenCredential().getAccessToken());
        apiContext.setConfigurationMap(paypalSdkConfig());
        return apiContext;
    }
}