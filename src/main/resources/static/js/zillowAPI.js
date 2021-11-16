import {ZILLOW_API_KEY} from "./config";
//property details
fetch("https://zillow-com1.p.rapidapi.com/property?zpid=2080998890", {
    "method": "GET",
    "headers": {
        "x-rapidapi-host": "zillow-com1.p.rapidapi.com",
        "x-rapidapi-key": ZILLOW_API_KEY
    }
})
    .then(response => response.json())
    .then(response => {
        if(response.ok) {
            console.log('SUCCESS')
        } else{
            console.log('Not Successful')
        }
        console.log(response);
        document.getElementsByClassName('zillowFetch').scr = <textarea name="zillowFetch" id="zillowFetch"/>
    })
    .catch(err => {
        console.error(err);
    });


// images and videos

fetch("https://zillow-com1.p.rapidapi.com/images?zpid=2080998890", {
    "method": "GET",
    "headers": {
        "x-rapidapi-host": "zillow-com1.p.rapidapi.com",
        "x-rapidapi-key": ZILLOW_API_KEY
    }
})
    .then(response => {
        console.log(response);
        document.getElementById('zillowImg').src = URL.createObjectURL(Blob);
    })
    .catch(err => {
        console.error(err);
    });