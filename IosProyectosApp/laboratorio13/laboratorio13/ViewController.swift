//
//  ViewController.swift
//  laboratorio13
//
//  Created by Alexander on 11/14/19.
//  Copyright © 2019 Alexander. All rights reserved.
//

import UIKit
import FirebaseAuth
import Firebase

class ViewController: UIViewController {

    @IBOutlet weak var loginButton: UIBarButtonItem!
    
    @IBOutlet weak var logOutButoon: UIBarButtonItem!
    
    @IBOutlet weak var LoginInfoLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    override func viewWillAppear(_ animated: Bool) {
        if (Auth.auth().currentUser != nil) {
            self.loginButton.isEnabled = false
            self.logOutButoon.isEnabled = true
            self.LoginInfoLabel.text = "Hello" + (Auth.auth().currentUser?.email)!
        } else {
            self.loginButton.isEnabled = true
            self.logOutButoon.isEnabled = false
            self.LoginInfoLabel.text = "Hello please login"
        }
    }
    
    @IBAction func logoutButtonClick(_ sender: Any) {
        if (Auth.auth().currentUser != nil) {
            do{
                try Auth.auth().signOut()
                self.loginButton.isEnabled = true
                self.logOutButoon.isEnabled = false
                self.LoginInfoLabel.text = "Hola porfavor ingrese"
            }catch let signOutError as NSError{
                print("Error en login",signOutError)
            }
                
        }
    
    }
    
}

