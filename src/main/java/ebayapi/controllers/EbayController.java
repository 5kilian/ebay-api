package ebayapi.controllers;

import ebayapi.models.EbaySearchResult;
import ebayapi.services.EbayHttpService;
import ebayapi.utils.EbaySearchRequest;
import ebayapi.services.EbaySearchParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EbayController {

    @Autowired
    EbayHttpService httpService;

    @Autowired
    EbaySearchParser searchParser;

    @RequestMapping("/")
    public EbaySearchResult hello() {
        return new EbaySearchResult("1");
    }

    @RequestMapping("/getEbay")
    public String helloworld() {
        String html = httpService.httpGet("/itm/302276015487");
        return html;

    }

    @RequestMapping("/getFFIV")
    public String getFFIV() {
        return httpService.httpGet(new EbaySearchRequest("Final Fantasy IV").inAuction());
    }

}
