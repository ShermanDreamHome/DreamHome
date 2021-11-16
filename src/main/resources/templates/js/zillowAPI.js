//property details
fetch("https://zillow-com1.p.rapidapi.com/property?zpid=2080998890", {
    "method": "GET",
    "headers": {
        "x-rapidapi-host": "zillow-com1.p.rapidapi.com",
        "x-rapidapi-key": "b2537f878dmsh5dd7af22e1bc03dp194973jsne0acd22b97a1"
    }
})
    .then(response => {
        if(response.ok) {
            console.log('SUCCESS')
        } else{
            console.log('Not Successful')
        }
        console.log(response);
    })
    .catch(err => {
        console.error(err);
    });


// images and videos

fetch("https://zillow-com1.p.rapidapi.com/images?zpid=2080998890", {
    "method": "GET",
    "headers": {
        "x-rapidapi-host": "zillow-com1.p.rapidapi.com",
        "x-rapidapi-key": "b2537f878dmsh5dd7af22e1bc03dp194973jsne0acd22b97a1"
    }
})
    .then(response => {
        console.log(response);
    })
    .catch(err => {
        console.error(err);
    });