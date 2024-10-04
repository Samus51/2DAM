import 'package:flutter/material.dart';

class Enlace4 extends StatelessWidget {
  const Enlace4({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Ejercicio 4'),
        ),
        body: const Center(
            child: Row(mainAxisAlignment: MainAxisAlignment.center, children: [
          Icon(
            Icons.heart_broken,
            size: 50.0,
            color: Colors.cyan,
          ),
          Icon(
            Icons.heart_broken,
            size: 50.0,
            color: Colors.red,
          ),
          Icon(
            Icons.heart_broken,
            size: 50.0,
            color: Colors.yellow,
          ),
          Icon(
            Icons.heart_broken,
            size: 50.0,
            color: Colors.orange,
          ),
          Icon(
            Icons.heart_broken,
            size: 50.0,
            color: Colors.purple,
          ),
        ])));
  }
}

/*home: Column(
      children: [
        Image.asset("assets/images/imagen.jpeg"),
        const Icon(
          Icons.abc,
          size: 120.0,
          color: Colors.cyan,
        ),
*/