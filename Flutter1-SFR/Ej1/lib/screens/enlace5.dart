import 'package:flutter/material.dart';

class Enlace5 extends StatelessWidget {
  const Enlace5({super.key});

  @override
  Widget build(BuildContext context) {
    return const Micontador(); // Aquí solo devuelves el widget que quieres mostrar
  }
}

class Micontador extends StatefulWidget {
  const Micontador({super.key});

  @override
  State<Micontador> createState() => _MicontadorState();
}

class _MicontadorState extends State<Micontador> {
  int contador = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Center(child: Text("Samuel Fernández Rodríguez")),
      ),
      body: Center(
        child: Text("Has pulsado $contador veces"),
      ),
      floatingActionButton: Row(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: [
          FloatingActionButton(
            onPressed: incrementar,
            child: const Text("+"),
          ),
          FloatingActionButton(
            onPressed: decrementar,
            child: const Text("-"),
          ),
          FloatingActionButton(
            onPressed: resetear,
            child: const Text("Reset"),
          ),
        ],
      ),
    );
  }

  void incrementar() {
    setState(() {
      contador++;
    });
  }

  void decrementar() {
    setState(() {
      if (contador > 0) {
        contador--;
      }
    });
  }

  void resetear() {
    setState(() {
      contador = 0;
    });
  }
}
