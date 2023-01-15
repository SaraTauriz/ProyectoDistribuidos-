const mongoose = require('mongoose')
const {MONGO_URI}=require('./index');


module.exports.dbc = async () => {
    try{
        mongoose.set("strictQuery", false);
        await mongoose.connect(MONGO_URI)
        console.log('Conexion exitosa con la base de datos')
    }catch(err){
        console.error(err)
        throw new Error('Error de conexion con la base de datos')
    }
}