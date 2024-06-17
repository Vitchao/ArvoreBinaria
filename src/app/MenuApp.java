package app;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuApp {
    public void Menu() {
        //AÇÕES DO BOTÕES
        Actions action = new Actions();

        //JANELA PRINCIPAL COM AS AÇÕES
        JFrame janela = new JFrame();

        /*BOTÃO -> CADASTRAR ALUNO*/
        JButton cadAlunoBtn = new JButton("Cadastrar Aluno");
        cadAlunoBtn.setBounds(150, 20, 210, 30);
        cadAlunoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame janCadAluno = new JFrame();

                //Begin - Campo de nome
                JLabel labelNome = new JLabel("Nome: ");
                labelNome.setBounds(50, 50, 80, 30);

                JTextField fieldNome = new JTextField();
                fieldNome.setBounds(110, 50, 300, 30);

                janCadAluno.add(labelNome);
                janCadAluno.add(fieldNome);
                //End - Campo de nome

                //Begin - Campo de matrícula
                JLabel labelMat = new JLabel("Matrícula: ");
                labelMat.setBounds(50, 100, 80, 30);

                JTextField fieldMat = new JTextField();
                fieldMat.setBounds(110, 100, 300, 30);

                janCadAluno.add(labelMat);
                janCadAluno.add(fieldMat);
                //End - Campo de matrícula

                //Begin - Botões: Cadastrar e Fechar
                JButton cadAluno = new JButton("Salvar");
                cadAluno.setBounds(125, 175, 100, 20);
                cadAluno.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Boolean chekOk = true;
                            String nome = fieldNome.getText();
                            int matricula = Integer.parseInt(fieldMat.getText());

                            if (nome.equals("")) {
                                chekOk = false;
                                JOptionPane.showMessageDialog(null, "É necessário um Nome para prosseguir");
                            }

                            /*if (String.format("" + matricula).equals("") && chekOk) {
                                chekOk = false;
                                JOptionPane.showMessageDialog(null, "É necessário uma Matrícula para prosseguir");
                            }*/

                            Aluno alunoSearch = action.ConsultarAlunoMatricula(matricula);
                            if (alunoSearch != null && chekOk) {
                                chekOk = false;
                                JOptionPane.showMessageDialog(null, "Matrícula " + matricula + " já inserida para o aluno " + alunoSearch.getNome());
                            }

                            if (chekOk) {
                                try {
                                    action.CadastrarAluno(new Aluno(matricula, nome));
                                    JOptionPane.showMessageDialog(null, "Aluno " + nome  + " cadastrado com sucesso");
                                } catch (Exception error) {
                                    JOptionPane.showMessageDialog(null, "Error ao Cadastrar Aluno");
                                }
                            }
                        } catch (NumberFormatException err) {
                            JOptionPane.showMessageDialog(null, "Número de matrícula inválido");
                        }
                    }
                });

                JButton closeCadAlu = new JButton("Fechar");
                closeCadAlu.setBounds(255, 175, 100, 20);
                closeCadAlu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        janCadAluno.dispose();
                    }
                });

                janCadAluno.add(closeCadAlu);
                janCadAluno.add(cadAluno);
                //End - Botões: Cadastrar e Fechar

                janCadAluno.setLayout(null);
                janCadAluno.setBounds(500, 100, 500, 500);

                janCadAluno.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                janCadAluno.setVisible(true);
            }
        });

        /*BOTÃO -> CADASTRAR DISCIPLINA*/
        JButton cadDisciplinaBtn = new JButton("Cadastrar Disciplina");
        cadDisciplinaBtn.setBounds(150, 60, 210, 30);
        cadDisciplinaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame janCadDisciplina = new JFrame();

                //Begin - Campo de Código
                JLabel labelCod = new JLabel("Código: ");
                labelCod.setBounds(50, 50, 80, 30);

                JTextField fieldCod = new JTextField();
                fieldCod.setBounds(140, 50, 300, 30);

                janCadDisciplina.add(labelCod);
                janCadDisciplina.add(fieldCod);
                //End - Campo de Código

                //Begin - Campo de Nome
                JLabel labelNome = new JLabel("Nome: ");
                labelNome.setBounds(50, 100, 80, 30);

                JTextField fieldNome = new JTextField();
                fieldNome.setBounds(140, 100, 300, 30);

                janCadDisciplina.add(labelNome);
                janCadDisciplina.add(fieldNome);
                //End - Campo de matrícula

                //Begin - Campo de Carga Horária
                JLabel labelCarga = new JLabel("Carga Horária: ");
                labelCarga.setBounds(50, 150, 90, 30);

                JTextField fieldCarga = new JTextField();
                fieldCarga.setBounds(140, 150, 300, 30);

                janCadDisciplina.add(labelCarga);
                janCadDisciplina.add(fieldCarga);
                //End - Campo de Carga Horária

                //Begin - Botões: Cadastrar e Fechar
                JButton cadDisciplina = new JButton("Salvar");
                cadDisciplina.setBounds(125, 215, 100, 20);
                cadDisciplina.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Boolean chekDisc = true;
                        String nome = fieldNome.getText();
                        int codigo = 0, cargaHoraria = 0;

                        try {
                            codigo = Integer.parseInt(fieldCod.getText());
                            try {
                                cargaHoraria = Integer.parseInt(fieldCarga.getText());
                            } catch (NumberFormatException errCarg) {
                                chekDisc = false;
                                JOptionPane.showMessageDialog(null, "Carga Horária inválida");
                            }
                        } catch (NumberFormatException errCod) {
                            chekDisc = false;
                            JOptionPane.showMessageDialog(null, "Código inválido");
                        }

                        if (nome.equals("") && chekDisc) {
                            chekDisc = false;
                            JOptionPane.showMessageDialog(null, "Nome de disciplina inválido");
                        }

                        if (chekDisc) {
                            Disciplina discSearch = action.ConsultarDisciplinaCodigo(codigo);
                            if (discSearch != null) {
                                chekDisc = false;
                                JOptionPane.showMessageDialog(null, "Disciplina " + discSearch.getNome() + " já possui este código cadastrado");
                            }
                        }

                        if (chekDisc) {
                            try {
                                action.CadastrarDisciplina(new Disciplina(codigo, nome, cargaHoraria));
                                JOptionPane.showMessageDialog(null, "Disciplina " + nome  + " cadastrado com sucesso");
                            } catch (Exception error) {
                                JOptionPane.showMessageDialog(null, "Error ao Cadastrar Disciplina");
                            }
                        }
                    }
                });

                JButton closeCadDisc = new JButton("Fechar");
                closeCadDisc.setBounds(255, 215, 100, 20);
                closeCadDisc.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        janCadDisciplina.dispose();
                    }
                });

                janCadDisciplina.add(closeCadDisc);
                janCadDisciplina.add(cadDisciplina);
                //End - Botões: Cadastrar e Fechar

                janCadDisciplina.setLayout(null);
                janCadDisciplina.setBounds(500, 100, 500, 500);

                janCadDisciplina.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                janCadDisciplina.setVisible(true);
            }
        });

        //BOTÃO -> INFORMAR PRÉ-REQUISITO
        JButton infRequiBtn = new JButton("Informar Pré-Requisito");
        infRequiBtn.setBounds(150, 100, 210, 30);
        infRequiBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame janInfReq = new JFrame();

                //BEGIN - Disciplina  N°1
                JLabel labelDis1 = new JLabel("Disciplina 1: ");
                labelDis1.setBounds(50, 50, 80, 30);

                JComboBox<String> comboBox1 = new JComboBox<>();
                comboBox1.setBounds(125, 50, 200, 30);
                comboBox1.addItem("");

                janInfReq.add(labelDis1);
                janInfReq.add(comboBox1);
                //END - Disciplina N°1

                //BEGIN - Disciplina N°2
                JLabel labelDis2 = new JLabel("Disciplina 2: ");
                labelDis2.setBounds(50, 100, 80, 30);

                JComboBox<String> comboBox2 = new JComboBox<>();
                comboBox2.addItem("");
                comboBox2.setBounds(125, 100, 200, 30);

                janInfReq.add(labelDis2);
                janInfReq.add(comboBox2);
                //END - Disciplina N°2

                String cleanList = action.toStringDisciplinas().replaceAll("[\\[\\]]", "");
                String[] linesList = cleanList.split("\n");
                for(String line : linesList) {
                    if (!line.equals("")) {
                        String[] parts = line.split(", ");
                        String codName = parts[0].split("Código = ")[1] + " - " + parts[1].split("Nome = ")[1];

                        comboBox1.addItem(codName);
                        comboBox2.addItem(codName);
                    }
                }

                //Begin - Botões: Salvar e Fechar
                JButton cadPreReq = new JButton("Salvar");
                cadPreReq.setBounds(125, 175, 100, 20);
                cadPreReq.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int codigo1 = Integer.parseInt(comboBox1.getSelectedItem().toString().split(" - ")[0]),
                                codigo2 = Integer.parseInt(comboBox2.getSelectedItem().toString().split(" - ")[0]);

                            Disciplina disciplina1 = action.ConsultarDisciplinaCodigo(codigo1),
                                       disciplina2 = action.ConsultarDisciplinaCodigo(codigo2);

                            if (disciplina1 != null && disciplina2 != null) {
                                action.InformarPreRequisito(disciplina1, disciplina2);
                                JOptionPane.showMessageDialog(null, disciplina1.getNome() + " agora é pré-requisito de " + disciplina2.getNome());
                            } else {
                                JOptionPane.showMessageDialog(null, "Não foi possível inserir Pré-requisito. Disciplina inválida");
                            }
                        } catch (NumberFormatException err) {
                        }
                    }
                });

                JButton closePreReq = new JButton("Fechar");
                closePreReq.setBounds(255, 175, 100, 20);
                closePreReq.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        janInfReq.dispose();
                    }
                });

                janInfReq.add(closePreReq);
                janInfReq.add(cadPreReq);
                //End - Botões: Salvar e Fechar

                janInfReq.setBounds(500, 100, 500, 500);
                janInfReq.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                janInfReq.setLayout(null);
                janInfReq.setVisible(true);
            }
        });

        //BOTÃO -> INFORMAR DISCIPLINA CURSADA
        JButton infDiscCurBtn = new JButton("Informar Disciplina Cursada");
        infDiscCurBtn.setBounds(150, 140, 210, 30);
        infDiscCurBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame janInfDisCur = new JFrame();

                //BEGIN - Lista de Alunos
                JLabel labelAluno = new JLabel("Aluno: ");
                labelAluno.setBounds(50, 50, 80, 30);

                JComboBox<String> alunos = new JComboBox<>();
                alunos.setBounds(115, 50, 200, 30);
                alunos.addItem("");

                String cleanAlunos = action.toStringAlunos().replaceAll("[\\[\\]]", "");
                String[] listAlunos  = cleanAlunos.split("\n");
                for(String aluno : listAlunos) {
                    if (!aluno.equals("")) {
                        String[] parts = aluno.split(", ");
                        String matNome = parts[0].split("Matrícula = ")[1] + " - " + parts[1].split("Nome = ")[1];

                        alunos.addItem(matNome);
                    }
                }

                janInfDisCur.add(labelAluno);
                janInfDisCur.add(alunos);
                //END - Lista de Alunos

                //BEGIN - Lista de Disciplinas
                JLabel labelDisciplina = new JLabel("Disciplina: ");
                labelDisciplina.setBounds(50, 100, 80, 30);

                JComboBox<String> disciplinas = new JComboBox<>();
                disciplinas.setBounds(115, 100, 200, 30);
                disciplinas.addItem("");

                String cleanDisciplinas = action.toStringDisciplinas().replaceAll("[\\[\\]]", "");
                String[] listDisciplinas = cleanDisciplinas.split("\n");
                for(String disciplina : listDisciplinas) {
                    if (!disciplina.equals("")) {
                        String[] parts = disciplina.split(", ");
                        String codName = parts[0].split("Código = ")[1] + " - " + parts[1].split("Nome = ")[1];

                        disciplinas.addItem(codName);
                    }
                }

                janInfDisCur.add(labelDisciplina);
                janInfDisCur.add(disciplinas);
                //END - Lista de Disciplinas

                //BEGIN - Botões: Salvar e Fechar
                JButton cadDisCur = new JButton("Salvar");
                cadDisCur.setBounds(125, 175, 100, 20);
                cadDisCur.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int matricula = Integer.parseInt(alunos.getSelectedItem().toString().split(" - ")[0]);
                            int codigo = Integer.parseInt(disciplinas.getSelectedItem().toString().split(" - ")[0]);

                            Aluno aluno = action.ConsultarAlunoMatricula(matricula);
                            Disciplina disciplina = action.ConsultarDisciplinaCodigo(codigo);

                            if (aluno != null && disciplina != null) {
                                ArrayList<Disciplina> discCursadas = aluno.getDisciplinasCursadas();
                                ArrayList<Disciplina> disRequisitos = disciplina.getPreRequisitos();

                                for(Disciplina disCursada : discCursadas) {
                                    if (disRequisitos.contains(disCursada)) {
                                        disRequisitos.remove(disCursada);
                                    }
                                }

                                if (disRequisitos.size() == 0) {
                                    action.InformarDisciplinaCursada(aluno, disciplina);
                                    JOptionPane.showMessageDialog(null, "Disciplina inserida com sucesso como cursada");
                                } else {
                                    int contador = 1;
                                    String message = "É necessário que o aluno " + aluno.getNome() + " faça as seguintes Disciplinas:\n";
                                    for(Disciplina requisito : disRequisitos) {
                                        message += contador + " - " + requisito.getNome() + "\n";
                                        contador++;
                                    }

                                    JOptionPane.showMessageDialog(null, message);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Não foi possível inserir disciplina como cursada");
                            }
                        } catch (NumberFormatException err) {
                        }
                    }
                });

                JButton closeInfCur = new JButton("Fechar");
                closeInfCur.setBounds(255, 175, 100, 20);
                closeInfCur.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        janInfDisCur.dispose();
                    }
                });

                janInfDisCur.add(cadDisCur);
                janInfDisCur.add(closeInfCur);
                //END - Botões: Salvar e Fechar

                janInfDisCur.setBounds(500, 100, 500, 500);
                janInfDisCur.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                janInfDisCur.setLayout(null);
                janInfDisCur.setVisible(true);
            }
        });

        //BOTÃO -> CONSULTAR ALUNO POR NOME
        JButton constAlunNome = new JButton("Consultar Aluno por Nome");
        constAlunNome.setBounds(150, 180, 210, 30);
        constAlunNome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame janConsNome = new JFrame();

                //BEGIN - Nome Aluno
                JLabel labelNome = new JLabel("Nome: ");
                labelNome.setBounds(50, 50, 80, 30);

                JTextField fieldNome = new JTextField();
                fieldNome.setBounds(110, 50, 200, 30);

                janConsNome.add(labelNome);
                janConsNome.add(fieldNome);
                //END - Nome Aluno

                //BEGIN - Botões: Pesquisar e Fechar
                JButton pesqAluno = new JButton("Pesquisar");
                pesqAluno.setBounds(125, 175, 100, 20);
                pesqAluno.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Aluno aluno = action.ConsultarAlunoNome(fieldNome.getText());
                        if (aluno != null) {
                            JOptionPane.showMessageDialog(null, action.DetalhesAluno(aluno));
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o aluno");
                        }
                    }
                });

                JButton closeConstNm = new JButton("Fechar");
                closeConstNm.setBounds(255, 175, 100, 20);
                closeConstNm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        janConsNome.dispose();
                    }
                });

                janConsNome.add(pesqAluno);
                janConsNome.add(closeConstNm);
                //END - Botões: Pesquisar e Fechar

                janConsNome.setBounds(500, 100, 500, 500);
                janConsNome.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                janConsNome.setLayout(null);
                janConsNome.setVisible(true);
            }
        });

        //BOTÃO -> CONSULTAR ALUNO POR MATRÍCULA
        JButton constAlunMat = new JButton("Consultar Aluno por Matrícula");
        constAlunMat.setBounds(150, 220, 210, 30);
        constAlunMat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame janConsMat = new JFrame();

                //BEGIN - Matrícula Aluno
                JLabel labelMat = new JLabel("Matrícula: ");
                labelMat.setBounds(50, 50, 80, 30);

                JTextField fieldMat = new JTextField();
                fieldMat.setBounds(110, 50, 200, 30);

                janConsMat.add(labelMat);
                janConsMat.add(fieldMat);
                //END - Matrícula Aluno

                //BEGIN - Botões: Pesquisar e Fechar
                JButton pesqAluno = new JButton("Pesquisar");
                pesqAluno.setBounds(125, 175, 100, 20);
                pesqAluno.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            int matricula = Integer.parseInt(fieldMat.getText());
                            Aluno aluno = action.ConsultarAlunoMatricula(matricula);

                            if (aluno != null) {
                                JOptionPane.showMessageDialog(null, action.DetalhesAluno(aluno));
                            } else {
                                JOptionPane.showMessageDialog(null, "Não foi possível encontrar o aluno");
                            }
                        } catch (NumberFormatException err) {
                            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o aluno");
                        }
                    }
                });

                JButton closeConstMat = new JButton("Fechar");
                closeConstMat.setBounds(255, 175, 100, 20);
                closeConstMat.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        janConsMat.dispose();
                    }
                });

                janConsMat.add(pesqAluno);
                janConsMat.add(closeConstMat);
                //END - Botões: Pesquisar e Fechar

                janConsMat.setBounds(500, 100, 500, 500);
                janConsMat.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                janConsMat.setLayout(null);
                janConsMat.setVisible(true);
            }
        });

        //BOTÃO -> EXCLUIR ALUNO POR MATRÍCULA
        JButton exlAlunoMat = new JButton("Excluir Aluno por Matrícula");
        exlAlunoMat.setBounds(150, 260, 210, 30);
        exlAlunoMat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame janExAluno = new JFrame();

                //BEGIN - Matrícula Aluno
                JLabel labelMat = new JLabel("Matrícula: ");
                labelMat.setBounds(50, 50, 80, 30);

                JTextField fieldMat = new JTextField();
                fieldMat.setBounds(110, 50, 200, 30);

                janExAluno.add(labelMat);
                janExAluno.add(fieldMat);
                //END - Matrícula Aluno

                //BEGIN - Botões: Excluir e Fechar
                JButton exAlunBtn = new JButton("Excluir");
                exAlunBtn.setBounds(125, 175, 100, 20);
                exAlunBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            int matricula = Integer.parseInt(fieldMat.getText());
                            Aluno aluno = action.ConsultarAlunoMatricula(matricula);

                            if (aluno != null) {
                                String message = (action.ExcluirAlunoMatricula(aluno) != null) ? "Aluno " + aluno.getNome() + " excluído com sucesso" : "Não foi excluir o aluno";
                                JOptionPane.showMessageDialog(null, message);
                            } else {
                                JOptionPane.showMessageDialog(null, "Não foi excluir o aluno");
                            }
                        } catch (NumberFormatException err) {
                            JOptionPane.showMessageDialog(null, "Não foi excluir o aluno");
                        }
                    }
                });

                JButton closeExAluno = new JButton("Fechar");
                closeExAluno.setBounds(255, 175, 100, 20);
                closeExAluno.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        janExAluno.dispose();
                    }
                });

                janExAluno.add(exAlunBtn);
                janExAluno.add(closeExAluno);
                //END - Botões: Excluir e Voltar

                janExAluno.setBounds(500, 100, 500, 500);
                janExAluno.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                janExAluno.setLayout(null);
                janExAluno.setVisible(true);
            }
        });

        //JANELA -> ADICIONANDO OS BOTÕES NA TELA
        janela.add(cadDisciplinaBtn);
        janela.add(cadAlunoBtn);
        janela.add(infRequiBtn);
        janela.add(infDiscCurBtn);
        janela.add(constAlunNome);
        janela.add(constAlunMat);
        janela.add(exlAlunoMat);

        janela.setLayout(null);
        janela.setBounds(500, 100, 500, 500);

        //JANELA -> DISPLAY
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
