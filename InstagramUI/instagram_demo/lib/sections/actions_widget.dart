import 'package:flutter/material.dart';

class ActionsWidget extends StatelessWidget {
  const ActionsWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        // Footer con botones redondeados
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            _buildImageWithText("Cancún"),
            _buildImageWithText("Arroyo Coches"),
            _buildImageWithText("Tiro Pichón"),
            _buildImageWithText("Bar Manolo"),
            _buildImageWithText("Lukas Grijander"),
          ],
        ),

        // Espacio debajo del footer
        const SizedBox(height: 20),
      ],
    );
  }

  // Método que construye cada imagen con texto debajo
  Widget _buildImageWithText(String text) {
    return Column(
      children: [
        ClipOval(
          child: TextButton(
            onPressed: () {},
            style: TextButton.styleFrom(
              padding: EdgeInsets.zero,
              shape: const CircleBorder(),
            ),
            child: Image.asset(
              "assets/images/image.png",
              width: 50,
              height: 50,
              fit: BoxFit.cover,
              errorBuilder: (context, error, stackTrace) {
                return const Icon(Icons.error,
                    size: 50); // Icono de error si la imagen no se carga
              },
            ),
          ),
        ),
        const SizedBox(height: 5), // Espacio entre la imagen y el texto
        Text(
          text,
          style: const TextStyle(fontSize: 12), // Estilo del texto
        ),
      ],
    );
  }
}
