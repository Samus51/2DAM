import 'package:flutter/material.dart';
import 'package:holamundo/screens/enlace1.dart';
import 'package:holamundo/screens/enlace2.dart';
import 'package:holamundo/screens/enlace3.dart';
import 'package:holamundo/screens/enlace4.dart';
import 'package:holamundo/screens/enlace5.dart';
import 'package:holamundo/screens/InstagramScreen.dart';

class MenuLateral extends StatelessWidget {
  const MenuLateral({super.key});

  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: ListView(
        children: <Widget>[
          const UserAccountsDrawerHeader(
            accountName: Text("Samuel Fernández Rodríguez"),
            accountEmail: Text("sferrod0401@g.educaand.es"),
            decoration: BoxDecoration(
              image: DecorationImage(
                image: AssetImage("assets/images/ibai.jpg"),
                fit: BoxFit.cover,
              ),
            ),
          ),
          ListTile(
            title: const Text("Pantalla 1"),
            onTap: () {
              Navigator.of(context).pop();
              Navigator.of(context).push(MaterialPageRoute(
                  builder: (BuildContext context) => const Enlace1()));
            },
          ),
          ListTile(
            title: const Text("Pantalla 2"),
            onTap: () {
              Navigator.of(context).pop();
              Navigator.of(context).push(MaterialPageRoute(
                  builder: (BuildContext context) => const Enlace2()));
            },
          ),
          ListTile(
            title: const Text("Pantalla 3"),
            onTap: () {
              Navigator.of(context).pop();
              Navigator.of(context).push(MaterialPageRoute(
                  builder: (BuildContext context) => const Enlace3()));
            },
          ),
          ListTile(
            title: const Text("Pantalla 4"),
            onTap: () {
              Navigator.of(context).pop();
              Navigator.of(context).push(MaterialPageRoute(
                  builder: (BuildContext context) => const Enlace4()));
            },
          ),
          ListTile(
            title: const Text("Pantalla 5"),
            onTap: () {
              Navigator.of(context).pop(); // Cierra el menú lateral
              Navigator.of(context).push(MaterialPageRoute(
                  builder: (BuildContext context) => const Enlace5()));
            },
          ),
          ListTile(
            title: const Text("Instagram"),
            onTap: () {
              Navigator.of(context).pop();
              Navigator.of(context).push(MaterialPageRoute(
                  builder: (BuildContext context) => const InstagramScreen()));
            },
          ),
        ],
      ),
    );
  }
}
