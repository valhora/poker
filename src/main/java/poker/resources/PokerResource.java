package poker.resources;

import poker.Poker;
import poker.model.Baralho;
import poker.model.Carta;
import poker.model.Mao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/")
public class PokerResource
{
   @Path("/")
   @GET
   @Produces("application/json")
   public Poker exampleGet()
   {
      return new Poker() ;
   }

}
