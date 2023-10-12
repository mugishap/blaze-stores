package com.management.resources;

import com.management.dtos.LoginDTO;
import com.management.entities.User;
import com.management.payload.ApiResponse;
import com.management.payload.AuthResponse;
import com.management.repositories.UserRepository;
import com.management.utils.PasswordEncoder;
import com.management.utils.TokenUtils;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Tag(ref = "Auth")
@Path("auth")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @ConfigProperty(name = "com.management.jwt.duration")
    public Long duration;
    @ConfigProperty(name = "mp.jwt.verify.issuer")
    public String issuer;

    @POST
    @Path("login")
    @PermitAll
    public Response login(
            @Valid LoginDTO dto
    ) {
        User user = this.userRepository.findByEmail(dto.getEmail());
        if (user != null && user.getPassword().equals(passwordEncoder.encode(dto.getPassword()))) {
            return Response.ok(
                    ApiResponse.success(
                            "Logged in successfully",
                            new AuthResponse(TokenUtils.generateToken(user.getId().toString(), user.getRoles(), duration, issuer)
                                    , user)
                    )
            ).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity(ApiResponse.error("Invalid credentials")).build();
        }
    }

}
