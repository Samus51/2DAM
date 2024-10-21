import 'package:flutter/material.dart';

class RectanglesWidget extends StatelessWidget {
  const RectanglesWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Padding(
          padding: const EdgeInsets.all(20),
          child: Container(
            width: 350,
            height: 20,
            decoration: BoxDecoration(
              color: Colors.white,
              border: Border.all(),
            ),
            child: const Center(
              child: Text(
                "Editar perfil",
                style: TextStyle(color: Colors.black),
              ),
            ),
          ),
        ),
      ],
    );
  }
}
