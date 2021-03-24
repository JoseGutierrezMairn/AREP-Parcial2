package edu.escuelaing.arep.app;

import static spark.Spark.*;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

/**
 * Hello world!
 *
 */
public class SparkWebServer 
{
	 private static Calculadora ca = new Calculadora();
	 private static Gson g = new Gson();

	    public static void main(String ... args){
	    	
	        port(getPort());
	        get("/hello", (req,res) -> "Hello!" );
	        get("/exp", SparkWebServer::getExp);
	        get("/cos",SparkWebServer::getCos);

	    }


	    private static Object getExp(Request request, Response response) {
	    	Double value = Double.valueOf(request.queryParams("value"));
	    	Answer answ = new Answer("exp", value, ca.exp(value));
	        return g.toJson(answ);
	    }


	    private static Object getCos(Request request, Response response) {
	    	Double value = Double.valueOf(request.queryParams("value"));
	    	Answer answ = new Answer("cos", value, ca.cos(value));
	        return g.toJson(answ);
	    }

	    private static int getPort() {
	        if (System.getenv("PORT") != null) {
	            return Integer.parseInt(System.getenv("PORT"));
	        }
	        return 5000;
	    }
}
