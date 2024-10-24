import 'package:flutter/material.dart';

import '../screensInstagram/GridViewWidget.dart';
import '../screensInstagram/LastFootWidget.dart';
import '../screensInstagram/actions_widget.dart';
import '../screensInstagram/footer_widget.dart';
import '../screensInstagram/header_widget.dart';
import '../screensInstagram/profile_widget.dart';

class InstagramScreen extends StatelessWidget {
  const InstagramScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: 'Scrollable App',
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: SingleChildScrollView(
          child: Column(
            children: [
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
