const express = require('express');
const axios = require('axios');

const app = express();

const planetServiceHostName = 'planet-service';
const planetServicePort = '8080';

app.listen(8081, () => {
    console.log('Listening on port 8081');
});

app.get('/report', async (req, res) => {
    let orphans = await getOrphans(3).catch(err => console.log(err));
    let hottest = await getHottest().catch(err => console.log(err));
    let summary = await getSummary().catch(err => console.log(err));

    let report = [orphans, hottest, ...summary];
    res.send(`<p>${report.join('</p><p>')}</p>`);
});

const getOrphans = async (type) => {
    let data = '';
    await axios.get(`http://${planetServiceHostName}:${planetServicePort}/planet/type/${type}`)
        .then((res) => {data = res.data})
        .catch(err => console.log(err));

    return `The number of planets of type ${type} (${data.description}) is ${data.count}.`;
};

const getHottest = async () => {
    let data = '';
    await axios.get(`http://${planetServiceHostName}:${planetServicePort}/planet/host/hottest`)
        .then((res) => {data = res.data})
        .catch(err => console.log(err));

    return `The name of the planet orbiting the hottest star is "${data.PlanetIdentifier}".`;
};

const getSummary = async () => {
    let data = '';
    let summary = [];

    await axios.get(`http://${planetServiceHostName}:${planetServicePort}/planet/summary`)
        .then((res) => {data = res.data})
        .catch(err => console.log(err));

    data.forEach( it => {
        let small = it.numberOfSmall;
        let medium = it.numberOfMedium;
        let large = it.numberOfLarge;

        summary.push(`In ${it.year} we discovered 
            ${small} small ${small === 1 ? 'planet,' : 'planets,'} 
            ${medium} medium ${medium === 1 ? 'planet,' : 'planets,'} and 
            ${large} large ${large === 1 ? 'planet.' : 'planets.'}`);
    });

    return summary;
};