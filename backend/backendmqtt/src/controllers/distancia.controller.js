const {response}= require('express')
const { DistanciaModel } = require('../model')




const insertarDistancia = async (message) => {
    var mensaje = new Object();
    mensaje.distancia = message;
    const autos = new DistanciaModel(mensaje);
    await autos.save();
}

const readDistancia = async (req, res) => {
    const data = await DistanciaModel.find()
    res.status(200).json(data)
}



module.exports={insertarDistancia,readDistancia};