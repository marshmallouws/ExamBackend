package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import errorhandling.GenericExceptionMapper;
import errorhandling.NotFoundException;
import utils.EMF_Creator;
import facades.FacadeExample;
import facades.MovieApiFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Todo Remove or change relevant parts before ACTUAL use
@Path("movies")
public class MovieRessource {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final MovieApiFacade FACADE = MovieApiFacade.getMovieApiFacade();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World..\"}";
    }
    
    @Path("/movie-info-simple/{title}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSimple(@PathParam("title") String title) {
        try {
            return Response.ok(FACADE.getMoviesSimple(title)).build();
        } catch (InterruptedException ex) {
            // TODO catch InterruptedException in facade and throw a custom exception
            return new GenericExceptionMapper().toResponse(ex);
        } catch (NotFoundException e) {
            return new GenericExceptionMapper().toResponse(e);
        }
    }
    
    @Path("/movie-info-all/{title}") 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@PathParam("title") String title) {
        try {
            return Response.ok(FACADE.getMoviesAll(title)).build();
        } catch (InterruptedException ex) {
            return new GenericExceptionMapper().toResponse(ex);
        } catch (NotFoundException e) {
            return new GenericExceptionMapper().toResponse(e);
        }
    }
}
