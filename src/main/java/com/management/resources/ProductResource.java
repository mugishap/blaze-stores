package com.management.resources;


import com.management.payload.ApiResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;

@Tag(ref = "Products")
@Path("products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @POST
    @Path("create")
    public Response createProduct() {
        return Response.status(Response.Status.CREATED).entity(ApiResponse.success("Product created successfully")).build();
    }
}
