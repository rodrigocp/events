# Eventos App

Aplicativo usando alguns conceitos de modularização, componentização e padrão MVVM.

### Bibliotecas:
- Retrofit: Para obtenção de dados via Rest API;
- DataBinding: Usado para vincular uma fonte de dados aos componentes UI;
- Koin: Injeção de dependências e instanciação;
- Navigation: Navegação entre telas;

## Módulos
### App
```
Aplicação principal, fornece contexto e instância
```
### Details
```
Módulo responsável pela exibição de detalhes do evento
```
### Main
```
Módulo responsável pela exibição da tela principal, no caso a lista de eventos.
```
### Domain
```
Módulo onde está localizado as classes de domínio e repositórios para leitura e escrita dos dados (SharedPreferences).
Pode ser expandida para usar Android Room.
```
### Remote
```
Módulo onde está repositórios para leitura e escrita de dados em um ou vários endpoins utilizando Rest APIs.
```
### Views
```
Módulo com algumas views personalizadas.
```
