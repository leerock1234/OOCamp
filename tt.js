console.log("test");
var webdriver = require("selenium-webdriver");
var Capabilities = webdriver.Capabilities;
var Builder = webdriver.Builder;

// var newCap = Capabilities.ie().set();

// webdriver.Capabilities.ENABLE_PERSISTENT_HOVER

var browser = new Builder().withCapabilities(Capabilities.ie()).build();

browser.get("http://localhost:63342/js/tt.html").then(
    function(value) {
        browser.findElement(webdriver.By.id("aa")).then(
            function(ll) {
                ll.sendKeys("abcdeffdafaf").then(function(value){
                    browser.quit();
                })
            }
        )
    }
);
