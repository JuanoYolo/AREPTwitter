package co.edu.escuelaing.Login;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

import co.edu.escuelaing.User;
import com.google.gson.Gson;
import com.google.common.hash.Hashing;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) throws CertificateException, KeyStoreException, IOException, NoSuchAlgorithmException, KeyManagementException {
        port(getPort());
        SecureURLReader.ssl();
        Gson gson=new Gson();
        Map<String,String> users=new HashMap<>();
        users.put("arepLab@gmail.com",Hashing.sha256().hashString("98765", StandardCharsets.UTF_8).toString());
        staticFileLocation("/public");
        secure("keystores/ecikeystore.p12", "arepLab", null, null);
        get("/hello", (req, res) -> "Hello World");
        get("/", (req, res) -> {
            res.redirect( "index.html");
            return "";
        });
        post("/login", (req, res) ->{
            req.session(true);
            User user = gson.fromJson(req.body(), User.class);
            if(Hashing.sha256().hashString(user.getPassword(), StandardCharsets.UTF_8).toString().equals(users.get(user.getEmail()))){
                req.session().attribute("User",user.getEmail());
                req.session().attribute("Loged",true);
            }
            else{
                return "Usuario o contraseña incorrecta, por favor ingresar de nuevo las credenciales";
            }
            return "";
        });
        get("/information", (req, res) -> {
            String resp = SecureURLReader.readURL("localHost:4567/information");
            System.out.println(resp);
            return resp;
        });
    }

    static int getPort(){
        if(System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
