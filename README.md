# <h1> ⭐ Aplicativo Álcool ou Gasolina

  ## Imagens do projeto
<p align="center">  
<img alt="Principal" src="https://user-images.githubusercontent.com/71935746/159597537-1607655a-dd45-43ca-a24e-b68fbf8aacef.png" width="250px" />
 <img alt="Principal" src="https://user-images.githubusercontent.com/71935746/159597925-fba57622-7817-4e8d-97b2-e3aa6e3afdc8.png" width="250px" />
</p>

  ## Descrição
 Esse Projeto foi desenvolvido na versão `Android Gadle Plugin Version 7.1.1`, `Gadle Version 7.2` no Android Studio.
 A Idéia é calcular qual combustível é mais viavél para realizar o abastecimento no seu veículo, o calculo é feito na seguinte maineira:
 #### Regra:  Se o preço do alcool for até 70% do preço da gasolina, ele é a melhor opção acima de 70% a gasolina é melhor opção
  ```java
 double resultado = precoAlcool / precoGasolina;
  if (resultado < 0.7)
     return "É melhor abastecer com Álcool";
  else
     return "É melhor abastecer com Gasolina";
 ```


