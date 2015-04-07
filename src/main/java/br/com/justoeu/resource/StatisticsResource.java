package br.com.justoeu.resource;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.airhacks.porcupine.execution.entity.Statistics;

@Path("statistics")
@RequestScoped
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class StatisticsResource {

    @Inject
    Instance<List<Statistics>> statistics;

    @GET
    public List<Statistics> expose() {
        return this.statistics.get();
    }

}