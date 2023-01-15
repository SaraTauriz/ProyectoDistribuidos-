const express = require('express')
const controller = require('../controllers/distancia.controller')

const DistanciaRouter = express.Router()


DistanciaRouter.get('/',controller.readDistancia)


module.exports = DistanciaRouter