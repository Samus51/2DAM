import 'package:flutter/material.dart';
import 'package:instagram_demo/sections/GridViewWidget.dart';
import 'package:instagram_demo/sections/LastFootWidget.dart';
import 'sections/actions_widget.dart';
import 'sections/footer_widget.dart';
import 'sections/header_widget.dart';
import 'sections/profile_widget.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Scrollable App',
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: SingleChildScrollView(
          child: Column(
            children: const [
              HeaderWidget(),
              ProfileWidget(),
              ActionsWidget(),
              FooterWidget(),
              GridViewWidget(),
              LastFootWidget(),
            ],
          ),
        ),
      ),
    );
  }
}
