package edu.escuelaing.arep.app;

import static spark.Spark.*;

import spark.Request;
import spark.Response;
/**
 * Hello world!
 *
 */
public class SparkWebServer 
{
	 private static Calculadora ca = new Calculadora();


	    public static void main(String ... args){
	        port(getPort());
	        get("/hello", (req,res) -> "Hello!" );
	        get("/sin", SparkWebServer::getSin);
	        get("/cos",SparkWebServer::getCos);

	    }


	    private static Object getSin(Request request, Response response) {
	    	Double value = Double.valueOf(request.queryParams("value"));
	        return null;
	    }


	    private static Object getCos(Request request, Response response) {
	    	Double value = Double.valueOf(request.queryParams("value"));
	        return null;
	    }

	    private static int getPort() {
	        if (System.getenv("PORT") != null) {
	            return Integer.parseInt(System.getenv("PORT"));
	        }
	        return 5000;
	    }
}
