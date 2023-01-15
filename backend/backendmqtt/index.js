const mqtt = require('mqtt')
const client  = mqtt.connect('mqtt://192.168.137.188')
const controller = require('./src/controllers/distancia.controller')

function EventoConectar () {
    client.subscribe('distancia', function (err) {
    })
}

function EventoMensaje (topic, message) {

    console.log(message.toString())
    controller.insertarDistancia(message);
    //client.end()
}

client.on('connect',EventoConectar);
client.on('message',EventoMensaje)



const Servidor = require('./src/server')
const server = new Servidor()
server.listen()