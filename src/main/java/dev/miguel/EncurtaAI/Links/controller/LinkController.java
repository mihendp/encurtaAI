package dev.miguel.EncurtaAI.Links.controller;

import dev.miguel.EncurtaAI.Links.dtos.LinkResponse;
import dev.miguel.EncurtaAI.Links.models.LinkModel;
import dev.miguel.EncurtaAI.Links.service.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/encurta-ai")
    public ResponseEntity<Object> gerarUrlEncurtada(@RequestBody Map<String, String> request){
            String urlOriginal = request.get("urlOriginal");
        if (urlOriginal == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não conseguimos receber sua url original.");
        }

        LinkModel linkModel = linkService.encurtarUrl(urlOriginal);

        String urlDeRedirecionamento = "http://localhost:8080/r/" + linkModel.getUrlEncurtada();

        LinkResponse response = new LinkResponse();
        BeanUtils.copyProperties(linkModel, response);
        response.setUrlEncurtada(urlDeRedirecionamento);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/r/{urlEncurtada}")
    public void redirecionarLink(@PathVariable String urlEncurtada, HttpServletResponse response) throws IOException {
        LinkModel link = linkService.obterUrlOriginal(urlEncurtada);

        if (link != null){
            response.sendRedirect(link.getUrlOriginal());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

    }
}
