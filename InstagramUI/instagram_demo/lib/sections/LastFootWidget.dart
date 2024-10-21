import 'package:flutter/material.dart';

class LastFootWidget extends StatelessWidget {
  const LastFootWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: 70, // Altura fija para el widget
      child: Row(
        mainAxisAlignment: MainAxisAlignment.start,
        children: List.generate(5, (index) {
          return Expanded(
            child: IconButton(
              onPressed: () {}, // Cambia esto según sea necesario
              color: Colors.green,
              icon: const Icon(Icons.star),
            ),
          );
        }),
      ),
    );
  }
}
