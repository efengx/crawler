package com.ofengx.crawler.controller

import com.ofengx.crawler.demo.MyCrawler
import com.ofengx.crawler.model.Element
import com.ofengx.crawler.repository.ElementRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import java.util.logging.Logger

@RestController
class HelloController {

    private final Logger log = Logger.getLogger(HelloController.class.getName())

    @Value('${crawler.path}')
    private String path

    @Autowired
    private ElementRepository elementRepository

    @GetMapping('/')
    String index() throws InterruptedException {
//        int numberOfCrawlers = 1
//
//        CrawlConfig config = new CrawlConfig()
//        String crawlSavePath = path + 'page'
//        System.out.println(crawlSavePath)
//        config.setCrawlStorageFolder(crawlSavePath)
////
//        config.setPolitenessDelay(1000)
//        config.setMaxDepthOfCrawling(2)
////        page number
//        config.setMaxPagesToFetch(2)
//        config.setIncludeBinaryContentInCrawling(false)
//        config.setResumableCrawling(false)
//
//        PageFetcher pageFetcher = new PageFetcher(config)
//        RobotstxtConfig robotstxtConfig = new RobotstxtConfig()
//        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher)
//        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer)
//
//        controller.addSeed('https://en.wikipedia.org/wiki/YouTube')
//        controller.start(MyCrawler.class, numberOfCrawlers)

        String imgPath = new MyCrawler().crawler('https://en.wikipedia.org/wiki/YouTube')
        if (imgPath) {
            Element element = new Element()
            element.setImgName(imgPath)
            elementRepository.save(element)
        }
        return "success"
    }
}
