package com.management.resources;

import com.management.dtos.CreateUserDTO;
import com.management.dtos.UpdateUserDTO;
import com.management.entities.User;
import com.management.enums.ERole;
import com.management.payload.ApiResponse;
import com.management.repositories.UserRepository;
import com.management.utils.PasswordEncoder;
import com.management.utils.TokenUtils;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.Collections;

@Tag(ref = "Users")
@Path("users")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    JsonWebToken jwt;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @POST
    @Path("create")
    public Response createUser(
            @Valid CreateUserDTO dto
    ) {
        try {
            User user = new User();
            user.setNames(dto.getNames());
            user.setEmail(dto.getEmail());
            user.setTelephone(dto.getTelephone());
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            user.setRoles(Collections.singleton(ERole.NORMAL));
            this.userRepository.persist(user);
            return Response.status(Response.Status.CONFLICT).entity(ApiResponse.success("User created successfully", user)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(ApiResponse.error("Error creating user")).build();
        }
    }

    @PUT
    @Path("update")
//    @RolesAllowed({"NORMAL", "ADMIN", "STORE_OWNER"})
    public Response updateUser(
            @Valid UpdateUserDTO dto
//            @Context SecurityContext ctx
    ) {
//        System.out.println(TokenUtils.getResponseString(ctx));
        return Response.ok().entity(ApiResponse.success("User updated successfully")).build();
    }


}
