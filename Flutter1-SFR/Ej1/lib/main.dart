import 'package:flutter/material.dart';
import 'package:holamundo/menuLateral.dart';

void main() => runApp(const Main());

class Main extends StatelessWidget {
  const Main({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Menú Principal',
      home: Scaffold(
        appBar: AppBar(
          title: const Text("Menú Principal"),
        ),
        drawer: const MenuLateral(),
        body: const Center(
          child: Text("Parte principal"),
        ),
      ),
    );
  }
}
