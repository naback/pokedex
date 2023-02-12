http://localhost:8080/pokemon/create
{
    "id": 21,
    "name": "Pikachu",
    "attack": 100,
    "defense": 100,
    "stamina": 100
}



http://localhost:8080/pokemon/list




http://localhost:8080/pokemon/search?pokemon=Pikachu




http://localhost:8080/pokemon/update?pokemon=Pikachu
{
    "name": "Pikachu Tunado",
    "attack": 300,
    "defense": 300,
    "stamina": 300
}




http://localhost:8080/pokemon/delete
{
    "id": 1,
    "name": "Charizard"
}






*TODO:* 
- implementar testes automatizados
- limpar mais codigo
- mudar delete pra get