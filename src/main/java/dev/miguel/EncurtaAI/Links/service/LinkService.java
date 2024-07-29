package dev.miguel.EncurtaAI.Links.service;

import dev.miguel.EncurtaAI.Links.models.LinkModel;
import dev.miguel.EncurtaAI.Links.repository.LinkRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LinkService {
    @Autowired
    private LinkRepository linkRepository;

    public String gerarUrlAleatoria(){
        return RandomStringUtils.randomAlphabetic(5, 10);
    }

    public LinkModel encurtarUrl(String urlOriginal){
        LinkModel linkModel = new LinkModel();
        linkModel.setUrlOriginal(urlOriginal);
        linkModel.setUrlEncurtada(gerarUrlAleatoria());
        linkModel.setTimestamp(LocalDateTime.now());
        linkModel.setUrlQrCode("QR CODE INDISPONÍVEL NO MOMENTO");

        return linkRepository.save(linkModel);
    }

    public LinkModel obterUrlOriginal(String urlEncurtada){
        try {
            return linkRepository.findByUrlEncurtada(urlEncurtada);
        }catch (Exception erro){
            throw new RuntimeException("Url não encontrada em nossos registros", erro);
        }
    }
}
