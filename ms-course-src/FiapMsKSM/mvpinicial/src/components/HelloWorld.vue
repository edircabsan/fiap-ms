<template>
  <div class="hello">
    <md-field>
      <label>Nome</label>
      <md-input v-model="nome" md-counter="30"></md-input>
    </md-field>
    <md-button class="md-primary" v-on:click="Salvar">Salvar</md-button>
  </div>
</template>
<script>
import Axios from 'axios'
import srapi from './serviceregister.json'
export default {
  name: 'HelloWorld',
  data () {
    return {
      nome: ''
    }
  },
  methods: {
    Salvar: function () {
      var buffer = JSON.stringify({Nome: this.nome})
      console.log(buffer)
      Axios.post(srapi.alunobackendlocalhost + 'savealuno', {
        headers: {
        'Content-Type': 'application/json'
      //'Content-Type': 'TEXT_PLAIN'
        },
        data: {
          tobuffer: buffer
        },
  })
  .then((response) => {
    console.log("aqui");
    //console.log(response);
    //console.log(response);
    console.log("oi");
    //console.log(response.data);
  name = response.data;
  console.log(name);
  }


)

    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
body { background-color: #cff; } /*azul claro*/
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
