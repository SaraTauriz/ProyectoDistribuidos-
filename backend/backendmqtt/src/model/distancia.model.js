const mongoose = require('mongoose');
const { Schema } = mongoose;

const DistanciaSchema = new Schema(
  {
    date: { 
      type: Date, default: Date.now 
    },
    distancia: {
      type: Number,
    }
  }
)

DistanciaSchema.methods.toJSON = function(){
  const {__v,_id, ...data}=this.toObject();
  return data;
}

module.exports = mongoose.model('distancia',DistanciaSchema)
