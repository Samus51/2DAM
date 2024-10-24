import 'package:flutter/material.dart';

class ProfileWidget extends StatelessWidget {
  const ProfileWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            Expanded(
              child: IconButton(
                onPressed: () {},
                icon: ClipOval(
                  child: Image.asset(
                    "assets/images/ibai.jpg",
                    width: 60,
                    height: 60,
                    fit: BoxFit.cover,
                  ),
                ),
              ),
            ),
            const Expanded(
              child: Text(
                "1026\nPublicaciones",
                textAlign: TextAlign.center,
              ),
            ),
            const Expanded(
              child: Text(
                "1026\nSeguidores",
                textAlign: TextAlign.center,
              ),
            ),
            const Expanded(
              child: Text(
                "1026\nSeguidos",
                textAlign: TextAlign.center,
              ),
            ),
          ],
        ),
        const SizedBox(height: 10), // Espacio entre filas
        const Row(
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            SizedBox(width: 10),
            Text(
              "Diseñador de apps para flutter\nMe llamo Ibai Negro\nCuenta de prueba\n",
              style: TextStyle(),
            ),
          ],
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Padding(
              padding: const EdgeInsets.all(10),
              child: Container(
                width: 350,
                height: 30, // Altura ajustada para el texto
                decoration: BoxDecoration(
                  border: Border.all(color: Colors.black, width: 2),
                ),
                child: const Center(
                  // Centrar el texto dentro del container
                  child: Text(
                    "Editar mi perfil",
                    textAlign: TextAlign.center,
                    style: TextStyle(fontSize: 16), // Estilo del texto
                  ),
                ),
              ),
            )
          ],
        )
      ],
    );
  }
}
