import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

final Uri url = Uri.parse('https://github.com/Samus51/2DAM');

class Enlace1 extends StatelessWidget {
  const Enlace1({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Ejercicio 1'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          mainAxisSize: MainAxisSize.min, // Establecer el tamaño mínimo
          children: <Widget>[
            Text(
              'Samuel Fernández Rodríguez',
              style: GoogleFonts.robotoCondensed(
                textStyle: const TextStyle(fontSize: 20),
              ),
            ),
            const SizedBox(height: 40),
            SelectableText(
              // Permite al usuario seleccionar y copiar el texto
              'https://github.com/Samus51/2DAM.git',
              style: GoogleFonts.lato(
                textStyle: const TextStyle(
                  fontSize: 20,
                  color: Colors.blue,
                  decoration: TextDecoration.underline,
                ),
              ),
              textAlign: TextAlign.center,  // Asegura que el texto esté centrado
            ),
          ],
        ),
      ),
    );
  }
}
