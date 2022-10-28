package co.edu.escuelaing;

import static spark.Spark.*;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

public class Main {
    public static void main(String[] args) {
            port(getPort());
            //get("/hello", (req, res) -> "Hello ");
            staticFiles.location("/public");
            /*post("/posts", (req, res) -> {
                res.type("application/json");

            });
             */
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}