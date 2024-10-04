import 'package:flutter/material.dart';
import 'package:holamundo/menuLateral.dart';

void main() => runApp(const MyApp());


class MyApp extends StatelessWidget {
  const MyApp({super.key});


  // This widget is the root of your application.
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
        ));
  }
}




      /*
      home:
      Center(child:Text("Paco el chocolatero",
      style: TextStyle(fontSize: 30,
      color: Colors.green,
      decoration: TextDecoration.none,
      letterSpacing: 1,
      */
  