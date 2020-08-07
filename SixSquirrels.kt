package com.zetcode



import java.awt.Dimension
import java.awt.EventQueue
import java.awt.Graphics
import java.awt.event.ActionEvent
import java.awt.event.InputEvent
import java.awt.event.KeyEvent
import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import javax.imageio.ImageIO
import javax.swing.*
import kotlin.system.exitProcess

var offset = 0



class SixSquirrels(title: String) : JFrame() {

    init {

        createUI(title)
        var a = 0

    }


    private fun createUI(title: String) {

        setTitle(title)

        createMenuBar()

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(300, 200)
        setLocationRelativeTo(null)
    }


    private fun createMenuBar() {

        val menubar = JMenuBar()

        val file = JMenu("File")
        val edit_menu = JMenu("Edit")
        val view_menu = JMenu("View")
        val window_menu = JMenu("Window")
        val help_menu = JMenu("Help")
        file.mnemonic = KeyEvent.VK_F

        val eMenuItem = JMenuItem("Close")
        eMenuItem.toolTipText = "Exit application"
        eMenuItem.addActionListener { _: ActionEvent -> exitProcess(0) }
        val keyStrokeToCloseWindow = KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.META_DOWN_MASK)
        eMenuItem.setAccelerator(keyStrokeToCloseWindow)

        file.add(eMenuItem)

        val faMenuItem = JMenuItem("Undo")
        faMenuItem.mnemonic = KeyEvent.VK_E
        faMenuItem.toolTipText = "Exit application"
        faMenuItem.addActionListener { _: ActionEvent -> exitProcess(0) }
        val keyStrokeToUndo = KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.META_DOWN_MASK)
        faMenuItem.setAccelerator(keyStrokeToUndo)

        edit_menu.add(faMenuItem)

        val fbMenuItem = JMenuItem("Redo")
        fbMenuItem.mnemonic = KeyEvent.VK_E
        fbMenuItem.toolTipText = "Exit application"
        fbMenuItem.addActionListener { _: ActionEvent -> exitProcess(0) }
        val keyStrokeToRedo = KeyStroke.getKeyStroke("shift meta pressed Z")
        fbMenuItem.setAccelerator(keyStrokeToRedo)

        edit_menu.add(fbMenuItem)
        edit_menu.addSeparator()

        val fcMenuItem = JMenuItem("Copy")
        fcMenuItem.mnemonic = KeyEvent.VK_E
        fcMenuItem.toolTipText = "Exit application"
        fcMenuItem.addActionListener { _: ActionEvent -> exitProcess(0) }
        val keyStrokeToCopy = KeyStroke.getKeyStroke("meta pressed C")
        fcMenuItem.setAccelerator(keyStrokeToCopy)

        edit_menu.add(fcMenuItem)

        val gaMenuItem = JMenuItem("Actual Size")
        gaMenuItem.mnemonic = KeyEvent.VK_E
        gaMenuItem.toolTipText = "Exit application"
        gaMenuItem.addActionListener { _: ActionEvent -> exitProcess(0) }

        //view_menu.add(gaMenuItem)

        val gbMenuItem = JMenuItem("Zoom In")
        gbMenuItem.mnemonic = KeyEvent.VK_E
        gbMenuItem.toolTipText = "Exit application"
        gbMenuItem.addActionListener { _: ActionEvent -> exitProcess(0) }
        val keyStrokeToZoomIn = KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, KeyEvent.META_DOWN_MASK)
        gbMenuItem.setAccelerator(keyStrokeToZoomIn)

        view_menu.add(gbMenuItem)

        val gcMenuItem = JMenuItem("Zoom Out")
        gcMenuItem.mnemonic = KeyEvent.VK_E
        gcMenuItem.toolTipText = "Exit application"
        gcMenuItem.addActionListener { _: ActionEvent -> exitProcess(0) }
        val keyStrokeToZoomOut = KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.META_DOWN_MASK)
        gcMenuItem.setAccelerator(keyStrokeToZoomOut)

        view_menu.add(gcMenuItem)
        view_menu.addSeparator()

        val gdMenuItem = JMenuItem("Next Squirrel")
       // gdMenuItem.mnemonic = KeyEvent.VK_E
        gdMenuItem.toolTipText = "Exit application"
        val keyStrokeToNextSquirrel = KeyStroke.getKeyStroke(KeyEvent.VK_CLOSE_BRACKET, KeyEvent.META_DOWN_MASK)
        gdMenuItem.setAccelerator(keyStrokeToNextSquirrel)
        gdMenuItem.addActionListener { _: ActionEvent -> addOne() }

        view_menu.add(gdMenuItem)

        val geMenuItem = JMenuItem("Previous Squirrel")
       // geMenuItem.mnemonic = KeyEvent.VK_E
        geMenuItem.toolTipText = "Exit application"
        geMenuItem.addActionListener { _: ActionEvent -> subtractOne() }
        val keyStrokeToPreviousSquirrel = KeyStroke.getKeyStroke(KeyEvent.VK_OPEN_BRACKET, KeyEvent.META_DOWN_MASK)
        geMenuItem.setAccelerator(keyStrokeToPreviousSquirrel)

        view_menu.add(geMenuItem)
        view_menu.addSeparator()

        val gfMenuItem = JMenuItem("Enter Full Screen")
        gfMenuItem.mnemonic = KeyEvent.VK_E
        gfMenuItem.toolTipText = "Exit application"
        val keyStrokeToFullScreen = KeyStroke.getKeyStroke("control meta pressed F")
        gfMenuItem.setAccelerator(keyStrokeToFullScreen)
      // gfMenuItem.addActionListener { _: ActionEvent ->  }

        view_menu.add(gfMenuItem)



        val haMenuItem = JMenuItem("Minimize")
        haMenuItem.mnemonic = KeyEvent.VK_E
        haMenuItem.toolTipText = "Exit application"
        val keyStrokeToMinimizeWindow = KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.META_DOWN_MASK)
        haMenuItem.setAccelerator(keyStrokeToMinimizeWindow)
        haMenuItem.addActionListener { _: ActionEvent -> setState(JFrame.ICONIFIED); }

        window_menu.add(haMenuItem)
        val hbMenuItem = JMenuItem("Zoom")
        hbMenuItem.mnemonic = KeyEvent.VK_E
        hbMenuItem.toolTipText = "Exit application"
        hbMenuItem.addActionListener { _: ActionEvent -> setExtendedState(JFrame.MAXIMIZED_BOTH);}


        window_menu.add(hbMenuItem)

        val iMenuItem = JMenuItem("About squirrels")
        iMenuItem.mnemonic = KeyEvent.VK_E
        iMenuItem.toolTipText = "Exit application"
        iMenuItem.addActionListener { _: ActionEvent -> exitProcess(0) }

        help_menu.add(iMenuItem)


        menubar.add(file)
        menubar.add(edit_menu)
        menubar.add(view_menu)
        menubar.add(window_menu)
        menubar.add(help_menu)

      


        jMenuBar = menubar
    }
}

private fun addOne() {
    offset = (offset + 1)
    ImagePanel().nextSquirrel()



}
private fun subtractOne() {
    offset = (offset - 1)
    ImagePanel().nextSquirrel()

}

private fun createAndShowGUI() {

    val frame = SixSquirrels("Six squirrel pictures")
    frame.isVisible = true
    frame.contentPane.add(ImagePanel())
}



















fun main(args: Array<String>) {
    System.setProperty("com.apple.awt.application.name","SixSquirrels");
    System.setProperty("apple.laf.useScreenMenuBar", "true");
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    val lcOSName = System.getProperty("os.name").toLowerCase()
    val IS_MAC = lcOSName.startsWith("mac os x")
    EventQueue.invokeLater(::createAndShowGUI)






}



public class ImagePanel : JPanel() {
    var image: BufferedImage? = null
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        g.drawImage(image, 0, 0, this) // see javadoc for more info on the parameters
        nextSquirrel()
        revalidate()
        repaint()

    }
    fun nextSquirrel() {
        if (offset == 0) {
            image = ImageIO.read(File("squirrel-2009311_1280.jpg"))
        }
        else if (offset == 1) {
            image = ImageIO.read(File("animal-1850210_1280.jpg"))
        }
        else if (offset == 2) {
            image = ImageIO.read(File("animal-3135855_1280.jpg"))
        }
        else if (offset == 3) {
            image = ImageIO.read(File("squirrel-493790_1280.jpg"))
        }
        else if (offset == 4) {
            image = ImageIO.read(File("squirrel-5158715_1280.jpg"))
        }
        else if (offset == 5) {
            image = ImageIO.read(File("animal-17819_1280.jpg"))
        }
        else {
            image = ImageIO.read(File("animal-1850210_1280.jpg"))

        }
    }



    init {
        try {

            image = ImageIO.read(File("./squirrel-2009311_1280.jpg"))
            var a = 0
        } catch (ex: IOException) {
            // handle exception...
        }
    }




}


