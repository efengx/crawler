package com.ofengx.crawler.demo

import com.ofengx.crawler.model.Element
import com.ofengx.crawler.repository.ElementRepository
import edu.uci.ics.crawler4j.crawler.Page
import edu.uci.ics.crawler4j.crawler.WebCrawler
import edu.uci.ics.crawler4j.parser.HtmlParseData
import edu.uci.ics.crawler4j.url.WebURL
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import java.util.regex.Pattern

@Component
class MyCrawler extends WebCrawler {

    private final static Pattern FILTERS = Pattern.compile('.*(\\.(css|js|gif|jpg|png|mp3|mp4|zip|gz))$')

    @Override
    boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase()
        return !FILTERS.matcher(href).matches() && href.startsWith('https://en.wikipedia.org/wiki/YouTube')
    }

    @Override
    void visit(Page page) {
        String url = page.getWebURL().getURL()

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData()
            String html = htmlParseData.getHtml()
            Document doc = Jsoup.parse(html)
            Elements newsHeadlines = doc.select('#mw-content-text a.image img')
            if (newsHeadlines.size() > 0) {
                String imgPath = newsHeadlines[0].attr('src')
                Element element = new Element()
                element.setImgName()
                elementRepository.save(new com.ofengx.crawler.model.Element().setImgName('http:'+ imgPath))
            }
        }
    }

    String crawler(String url) {
        Document doc = Jsoup.connect(url).get()
        Elements newsHeadlines = doc.select('#mw-content-text a.image img')
        if (newsHeadlines.size() > 0) {
            String imgPath = newsHeadlines[0].attr('src')
            return imgPath
        }
    }
}