# Calculadora Desktop Java com MVC

Uma aplicação de calculadora desktop funcional desenvolvida em Java utilizando o padrão de projeto **MVC (Model-View-Controller)** e **Java Swing** para a interface gráfica.

## Estrutura do Projeto

```
baseCalcCode/
├── src/                          # Código fonte
│   ├── Calculator.java           # Classe principal com método main
│   ├── model/
│   │   └── CalculatorModel.java  # Model (lógica matemática)
│   ├── view/
│   │   └── CalculatorView.java   # View (interface gráfica com Swing)
│   └── controller/
│       └── CalculatorController.java  # Controller (gerenciamento de eventos)
├── bin/                          # Arquivos compilados (gerados automaticamente)
└── README.md
```

### Descrição das Classes

1. **Calculator.java** - Classe principal com método `main` que inicializa a aplicação
2. **model/CalculatorModel.java** - Model (lógica matemática)
3. **view/CalculatorView.java** - View (interface gráfica com Swing)
4. **controller/CalculatorController.java** - Controller (gerenciamento de eventos)

## Funcionalidades

✅ Operações básicas: Adição (+), Subtração (-), Multiplicação (*), Divisão (/)
✅ Suporte a números decimais (ponto flutuante)
✅ Botão "C" para limpar o display
✅ Botão "=" para processar o resultado
✅ Tratamento de divisão por zero (exibe "Erro")
✅ Evita múltiplos pontos decimais no mesmo número

## Como Compilar e Executar

### Pré-requisitos
- Java Development Kit (JDK) 8 ou superior

### Compilação

```bash
cd baseCalcCode/src
javac -d ../bin Calculator.java model/CalculatorModel.java view/CalculatorView.java controller/CalculatorController.java
```

### Execução

```bash
cd baseCalcCode
java -cp bin Calculator
```

### Alternativa: Compilação e Execução em um Único Comando

```bash
cd baseCalcCode && javac -d bin src/*.java src/model/*.java src/view/*.java src/controller/*.java && java -cp bin Calculator
```

## Arquitetura MVC

### Model (src/model/CalculatorModel.java)
- Encapsula toda a lógica matemática
- Gerencia o estado interno da calculadora
- Independente da interface gráfica
- Declara package `model`
- Métodos principais:
  - `addDigit(String digit)` - Adiciona um dígito
  - `addDecimalPoint()` - Adiciona ponto decimal
  - `setOperation(String op)` - Define operação
  - `calculateResult()` - Calcula o resultado
  - `clear()` - Limpa a calculadora

### View (src/view/CalculatorView.java)
- Responsável pela construção da interface gráfica
- Utiliza JFrame, JTextField e JButton
- GridLayout (4x4) para organizar os botões
- Display em JTextField somente leitura
- Métodos getters para acessar os componentes
- Declara package `view`

### Controller (src/controller/CalculatorController.java)
- Gerencia todos os eventos (ActionListener)
- Conecta a View ao Model
- Processa cliques de botões
- Atualiza o display conforme necessário
- Valida entrada do usuário
- Declara package `controller`

### Main (src/Calculator.java)
- Inicializa a aplicação (padrão MVC)
- Instancia Model, View e Controller
- Importa packages: model, view, controller

## Qualidade de Código

✅ Nomenclatura CamelCase em conformidade com convenções Java
✅ JavaDoc completo em todas as classes e métodos públicos
✅ Código limpo, modular e bem organizado
✅ Separação clara de responsabilidades
✅ Tratamento de exceções para divisão por zero
✅ Método main apenas inicializa a aplicação

## Exemplo de Uso

1. Digite um número (ex: 5)
2. Clique em uma operação (ex: +)
3. Digite outro número (ex: 3)
4. Clique em "=" para ver o resultado (8)
5. Clique em "C" para limpar e começar novamente

## Tratamento de Erros

- **Divisão por zero**: Exibe "Erro" no display
- **Múltiplos pontos decimais**: O botão "." só adiciona um ponto por número
- **Operações inválidas**: Tratadas graciosamente pelo Controller

## Autor

Desenvolvido seguindo as melhores práticas de engenharia de software e padrões de projeto Java.
