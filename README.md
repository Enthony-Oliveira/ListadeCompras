# 🛒 Lista de Compras - App Android Nativo

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)
![XML](https://img.shields.io/badge/XML-Orange?style=for-the-badge&logo=html5&logoColor=white)

Aplicação Android nativa desenvolvida para gerenciamento prático e intuitivo de listas de compras no dia a dia. O aplicativo permite cadastrar itens, ajustar quantidades, remover produtos e integrar com a **câmera do dispositivo** para registrar fotos reais dos produtos cadastrados.

---

## 📱 Demonstração do Projeto

> 💡 *Substitua o link abaixo por uma foto ou GIF do app funcionando no seu celular/emulador!*

| Tela Principal / Lista | Captura de Foto do Produto |
| :-: | :-: |
| ![Preview](https://via.placeholder.com/250x500?text=Prints+do+App) | ![Preview](https://via.placeholder.com/250x500?text=Camera+do+App) |

---

## ✨ Funcionalidades Principais

- ➕ **Adição de Itens:** Cadastro de novos produtos na lista de compras.
- 📸 **Integração com Câmera:** Registro fotográfico do produto em tempo real utilizando a câmera nativa do Android.
- 🔢 **Controle de Quantidade:** Incremento e decremento rápido da quantidade de cada item.
- 🗑️ **Remoção de Produtos:** Exclusão individual de itens da lista de forma simples.
- 📱 **Layout Responsivo:** Interface construída em XML com foco na usabilidade do usuário final.

---

## 🛠️ Tecnologias e Conceitos Aplicados

- **Linguagem:** [Kotlin](https://kotlinlang.org/)
- **IDE:** Android Studio
- **Layouts:** XML (ConstraintLayout / LinearLayout)
- **Componentes e Recursos do Android:**
  - `RecyclerView` & `Adapter` para renderização e manipulação dinâmica de listas.
  - `Intents` nativas para invocação do app de câmera do sistema.
  - Gerenciamento de permissões de hardware no Android.
  - Trtatamento de imagens/bitmaps.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Android Studio instalado (versão Giraffe ou superior recomendada).
- Dispositivo Android físico (recomendado para testar a câmera) ou Emulador configurado com câmera habilitada.
- JDK 11 ou superior.

### Passo a Passo

1. **Clonar o repositório:**
   ```bash
   git clone [https://github.com/Enthony-Oliveira/ListadeCompras.git](https://github.com/Enthony-Oliveira/ListadeCompras.git)
