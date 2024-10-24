import 'package:flutter/material.dart';

class Enlace2 extends StatelessWidget {
  const Enlace2({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Ejercicio 2'),
        ),
        body: Center(
            child:
                Column(mainAxisAlignment: MainAxisAlignment.center, children: [
          Image.asset("assets/images/ibai.jpg", scale: 2.5,),
          Image.asset("assets/images/ibai.jpg", scale: 2.5),
          Image.asset("assets/images/ibai.jpg", scale: 2.5),
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